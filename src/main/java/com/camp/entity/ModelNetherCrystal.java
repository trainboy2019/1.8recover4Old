package com.camp.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelNetherCrystal extends ModelBase
{
    /** The cube model for the Ender Crystal. */
    private ModelRenderer cube;
    /** The glass model for the Ender Crystal. */
    private ModelRenderer glass = new ModelRenderer(this, "glass");
    /** The base model for the Ender Crystal. */
    private ModelRenderer base;
    private static final String __OBFID = "CL_00000871";

    public ModelNetherCrystal(float p_i1170_1_, boolean p_i1170_2_)
    {
        this.glass.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
        this.cube = new ModelRenderer(this, "cube");
        this.cube.setTextureOffset(32, 0).addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);

        if (p_i1170_2_)
        {
            this.base = new ModelRenderer(this, "base");
            this.base.setTextureOffset(0, 16).addBox(-6.0F, 0.0F, -6.0F, 12, 4, 12);
        }
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0F, 2.0F, 2.0F);
        GlStateManager.translate(0.0F, -0.5F, 0.0F);

        if (this.base != null)
        {
            this.base.render(p_78088_7_);
        }

        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, 0.8F + p_78088_4_, 0.0F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        this.glass.render(p_78088_7_);
        float f6 = 0.875F;
        GlStateManager.scale(f6, f6, f6);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        this.glass.render(p_78088_7_);
        GlStateManager.scale(f6, f6, f6);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(60.0F, 0.7071F, 0.0F, 0.7071F);
        GlStateManager.rotate(p_78088_3_, 0.0F, 1.0F, 0.0F);
        this.cube.render(p_78088_7_);
        GlStateManager.popMatrix();
    }
}