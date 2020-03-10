package minegame159.meteorclient.alts;

import minegame159.meteorclient.MeteorClient;
import minegame159.meteorclient.utils.Color;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.LiteralText;

public class AltManagerScreen extends Screen {
    private Screen parent;

    private int textColor = Color.fromRGBA(255, 255, 255, 255);
    private TextFieldWidget username, password;

    public AltManagerScreen(Screen parent) {
        super(new LiteralText("Alt Manager"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        username = addButton(new TextFieldWidget(font, width / 2 - 50, height / 2 - 24 - 10, 100, 20, ""));
        password = addButton(new TextFieldWidget(font, width / 2 - 50, height / 2 - 24 - 10 + 24, 100, 20, ""));

        addButton(new ButtonWidget(width / 2 - 51, height / 2 - 24 - 10 + 24 * 2, 102, 20, "Log In", button -> {
            MeteorClient.INSTANCE.logIn(username.getText(), password.getText());
            minecraft.openScreen(parent);
        }));
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        renderBackground();
        super.render(mouseX, mouseY, delta);

        drawString(font, "Email:", width / 2 - 50 - font.getStringWidth("Email:") - 4, height / 2 - 24 - 10 + 6, textColor);
        drawString(font, "Password:", width / 2 - 50 - font.getStringWidth("Password:") - 4, height / 2 - 24 - 10 + 24 + 6, textColor);
    }

    @Override
    public void onClose() {
        minecraft.openScreen(parent);
    }
}