package shukaro.artifice.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import shukaro.artifice.render.IconHandler;

import java.util.List;
import java.util.Locale;

public class ItemUpgrade extends ItemArtifice
{
    private Icon[] icons = new Icon[13];
    private String[] upgrades = {"Sharpening Kit", "Reinforcement", "Reinforced Limbs", "Plaited String", "Counterweight", "Armor Spikes", "Laminated Padding", "Quilted Cover", "Elastic Soles", "Firedamp", "Elastic Layering", "Scuba Tank", "Dive Kit"};

    public ItemUpgrade(int id)
    {
        super(id);
        this.setUnlocalizedName("artifice.upgrade");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta)
    {
        return icons[meta];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg)
    {
        for (int i = 0; i < upgrades.length; i++)
        {
            icons[i] = IconHandler.registerSingle(reg, upgrades[i].toLowerCase(Locale.ENGLISH).replaceAll("\\s", ""), "upgrade");
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(int id, CreativeTabs tab, List list)
    {
        for (int i = 0; i < upgrades.length; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "item.artifice.upgrade." + upgrades[stack.getItemDamage()].toLowerCase(Locale.ENGLISH).replaceAll("\\s", "");
    }
}
