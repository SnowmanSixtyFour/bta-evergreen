package snowmansixtyfour.evergreen.mixin;

import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.render.RenderEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = GuiMainMenu.class, remap = false)
public class GuiMainMenuMixin extends GuiScreen {
	//HUGE thanks to Cookie Cakes for helping me write this! -Snowman64
	@Redirect(method = "drawScreen",
		at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/render/RenderEngine;getTexture(Ljava/lang/String;)I"))
	private int evergreen_setLogo(RenderEngine instance, String e) {
		 return mc.renderEngine.getTexture("assets/evergreen/gui/evergreen_logo.png");
	}
}
