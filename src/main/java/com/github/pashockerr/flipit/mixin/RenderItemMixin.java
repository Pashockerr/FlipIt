package com.github.pashockerr.flipit.mixin;

import com.github.pashockerr.flipit.AnimationState;
import com.github.pashockerr.flipit.config.ModConfig;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.*;

@Mixin(ItemInHandRenderer.class)
public abstract class RenderItemMixin{
    @Shadow
    @Final
    private ItemRenderer itemRenderer;

    /**
     * @author Pashockerr
     * @reason Add rotation animation to items in hands
     */
    @Overwrite
    public void renderItem(LivingEntity entity, ItemStack itemStack, ItemDisplayContext displayContext, boolean leftHand, PoseStack poseStack, MultiBufferSource buffer, int seed) {
        if (!itemStack.isEmpty()) {
            poseStack.pushPose();
            if((AnimationState.lAnimationRunning && leftHand) || (AnimationState.rAnimationRunning && !leftHand)){
                float partialTick = Minecraft.getInstance().gameRenderer.getMainCamera().getPartialTickTime();
                float rotation;
                float translation;

                if(leftHand){
                    rotation = org.joml.Math.lerp(AnimationState.lRotationTime * AnimationState.getAngularSpeed(), AnimationState.lRotationTime * AnimationState.getAngularSpeed() + AnimationState.getAngularSpeed(), partialTick);
                    translation = Math.max((float)Math.sin(org.joml.Math.lerp(AnimationState.lRotationTime * AnimationState.getLinearSpeed(), AnimationState.lRotationTime * AnimationState.getLinearSpeed() + AnimationState.getLinearSpeed(), partialTick) / 2.0f), 0);
                }
                else{
                   rotation = org.joml.Math.lerp(AnimationState.rRotationTime * AnimationState.getAngularSpeed(), AnimationState.rRotationTime * AnimationState.getAngularSpeed() + AnimationState.getAngularSpeed(), partialTick);
                    translation = Math.max((float)Math.sin(org.joml.Math.lerp(AnimationState.rRotationTime * AnimationState.getLinearSpeed(), AnimationState.rRotationTime * AnimationState.getLinearSpeed() + AnimationState.getLinearSpeed(), partialTick) / 2.0f), 0);
                }

                poseStack.translate(0, translation, 0);
                poseStack.mulPose(new Matrix4f().rotate(rotation, 1.0f, 0, 0));
            }

            this.itemRenderer.renderStatic(entity, itemStack, displayContext, leftHand, poseStack, buffer, entity.level(), seed, OverlayTexture.NO_OVERLAY, entity.getId() + displayContext.ordinal());

            poseStack.popPose();

            if(AnimationState.lRotationTime >= AnimationState.getlRotationTime()){
                AnimationState.lAnimationRunning = false;
                AnimationState.lRotationTime = 0;
            }
            if(AnimationState.rRotationTime >= AnimationState.getlRotationTime()){
                AnimationState.rAnimationRunning = false;
                AnimationState.rRotationTime = 0;
            }
        }
    }
}
