package com.cortez.adventuremod.screen.coffee_machine;

import com.cortez.adventuremod.AdventureMod;
import com.cortez.adventuremod.screen.coffee_machine.renderer.EnergyInfoArea;
import com.cortez.adventuremod.screen.coffee_machine.renderer.FluidStackRenderer;
import com.cortez.adventuremod.util.MouseUtil;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CoffeeMachineScreen extends HandledScreen<CoffeeMachineScreenHandler>
{
    private static final Identifier TEXTURE = new Identifier(AdventureMod.MODID, "textures/gui/coffee_machine_gui.png");

    private EnergyInfoArea energyInfoArea;
    private FluidStackRenderer waterStackRenderer;
    private FluidStackRenderer coffeeStorage;


    public CoffeeMachineScreen(CoffeeMachineScreenHandler handler, PlayerInventory inventory, Text title)
    {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        playerInventoryTitleY = 1000;
        assignEnergyInfoArea();
        assignWaterStackRenderer();
        assignCoffeeStackRenderer();
    }


    private void assignEnergyInfoArea() {
        energyInfoArea = new EnergyInfoArea(((width - backgroundWidth) / 2) + 160,
                ((height - backgroundHeight) / 2 ) + 27, handler.blockEntity.energyStorage);
    }

    private void assignWaterStackRenderer() {
        waterStackRenderer = new FluidStackRenderer((FluidConstants.BUCKET / 81) * 2, true, 16, 39);
    }

    private void assignCoffeeStackRenderer() {
        coffeeStorage = new FluidStackRenderer((FluidConstants.BUCKET / 81) * 2, true, 16, 39);
    }

    private void renderEnergyAreaTooltips(DrawContext context, int pMouseX, int pMouseY, int x, int y) {
        if(isMouseAboveArea(pMouseX, pMouseY, x, y, 160, 27, 8, 64)) {
            context.drawTooltip(Screens.getTextRenderer(this), energyInfoArea.getTooltips(),
                    Optional.empty(), pMouseX - x, pMouseY - y);
        }
    }

    private void renderWaterTooltip(DrawContext context, int mouseX, int mouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        if(isMouseAboveArea(mouseX, mouseY, x, y, offsetX, offsetY, renderer)) {
            context.drawTooltip(Screens.getTextRenderer(this), renderer.getTooltip(handler.blockEntity.waterStorage, TooltipContext.Default.BASIC),
                    Optional.empty(), mouseX - x, mouseY - y);
        }
    }

    private void renderCoffeeTooltip(DrawContext context, int mouseX, int mouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        if(isMouseAboveArea(mouseX, mouseY, x, y, offsetX, offsetY, renderer)) {
            context.drawTooltip(Screens.getTextRenderer(this), renderer.getTooltip(handler.blockEntity.coffeeStorage, TooltipContext.Default.BASIC),
                    Optional.empty(), mouseX - x, mouseY - y);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        super.drawForeground(context, mouseX, mouseY);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;


        renderEnergyAreaTooltips(context, mouseX, mouseY, x, y);
        renderWaterTooltip(context, mouseX, mouseY, x, y, 31, 25, waterStackRenderer);
        renderCoffeeTooltip(context, mouseX, mouseY, x, y,111, 26, coffeeStorage );
        context.drawTexture(TEXTURE, 30, 24, 176, 17, 16, 50);
        context.drawTexture(TEXTURE, 110, 25, 176, 17, 16, 50);
        super.drawForeground(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        energyInfoArea.draw(context);
        waterStackRenderer.drawFluid(context, handler.blockEntity.waterStorage, x + 31, y + 25, 14, 48,
                (FluidConstants.BUCKET / 81) * 2);

        coffeeStorage.drawFluid(context, handler.blockEntity.coffeeStorage, x + 111, y + 26, 14, 48,
                (FluidConstants.BUCKET / 81) * 2);


    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 81, y + 40, 176, 0, handler.getScaledProgress(), 17);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, FluidStackRenderer renderer) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, renderer.getWidth(), renderer.getHeight());
    }


    private boolean isMouseAboveArea(int pMouseX, int pMouseY, int x, int y, int offsetX, int offsetY, int width, int height) {
        return MouseUtil.isMouseOver(pMouseX, pMouseY, x + offsetX, y + offsetY, width, height);
    }
}
