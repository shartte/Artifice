package shukaro.artifice.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * This class allows for OreDictionary-compatible ItemStack comparisons.
 * <p/>
 * The intended purpose of this is for things such as Recipe Handlers or HashMaps of ItemStacks.
 *
 * @author King Lemming
 */
public class ComparableItemStack
{

    public int itemID = -1;
    public int metadata = -1;
    public int stackSize = -1;
    public int oreID = -1;

    public ComparableItemStack(ItemStack stack)
    {

        if (stack != null)
        {
            itemID = stack.itemID;
            metadata = stack.getItemDamage();
            stackSize = stack.stackSize;
            oreID = OreDictionary.getOreID(stack);
        }
    }

    public ComparableItemStack(int itemID, int damage, int stackSize)
    {

        this.itemID = itemID;
        this.metadata = damage;
        this.stackSize = stackSize;
        this.oreID = OreDictionary.getOreID(this.toItemStack());
    }

    public ComparableItemStack(ComparableItemStack stack)
    {

        this.itemID = stack.itemID;
        this.metadata = stack.metadata;
        this.stackSize = stack.stackSize;
        this.oreID = stack.oreID;
    }

    public ComparableItemStack(String oreName)
    {

        if (!OreDictionary.getOres(oreName).isEmpty())
        {
            ItemStack ore = OreDictionary.getOres(oreName).get(0);
            itemID = ore.itemID;
            metadata = ore.getItemDamage();
            stackSize = 1;
            oreID = OreDictionary.getOreID(oreName);
        }
    }

    public boolean isItemEqual(ComparableItemStack other)
    {

        return other != null && (oreID != -1 && oreID == other.oreID || itemID == other.itemID && metadata == other.metadata);
    }

    public boolean isStackEqual(ComparableItemStack other)
    {

        return isItemEqual(other) && stackSize == other.stackSize;
    }

    public boolean isStackValid()
    {

        return getItem() != null;
    }

    public Item getItem()
    {

        return itemID < 0 || itemID >= 32000 ? null : Item.itemsList[itemID];
    }

    public ItemStack toItemStack()
    {

        return itemID < 0 || itemID >= 32000 ? null : new ItemStack(itemID, stackSize, metadata);
    }

    @Override
    public ComparableItemStack clone()
    {

        return new ComparableItemStack(this);
    }

    @Override
    public int hashCode()
    {

        return oreID != -1 ? oreID : metadata | itemID << 16;
    }

    @Override
    public boolean equals(Object o)
    {

        return o instanceof ComparableItemStack && isItemEqual((ComparableItemStack) o);
    }

}
