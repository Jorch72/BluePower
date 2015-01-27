package com.bluepowermod.part.gate.ic;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.IChunkLoader;
import net.minecraft.world.storage.IPlayerFileData;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.util.ForgeDirection;
import uk.co.qmunity.lib.init.QLBlocks;
import uk.co.qmunity.lib.tile.TileMultipart;

public class FakeWorldIC extends World {

    private static FakeWorldIC INSTANCE = new FakeWorldIC();

    public static FakeWorldIC getInstance() {

        return INSTANCE;
    }

    private GateIntegratedCircuit ic;

    public FakeWorldIC() {

        super(new FakeWorldSaveHandler(), "IC_Fake_World", null, new WorldProvider() {

            @Override
            public String getDimensionName() {

                return "IC_Fake_World";
            }
        }, new Profiler());
    }

    public void setIC(GateIntegratedCircuit ic) {

        this.ic = ic;
    }

    public GateIntegratedCircuit getIC() {

        return ic;
    }

    // private GateBase<?, ?, ?, ?, ?, ?> get(int x, int z) {
    //
    // if (getIC() == null)
    // return null;
    //
    // return getIC().getGate(x, z);
    // }

    private TileMultipart getTile(int x, int z) {

        if (getIC() == null)
            return null;

        return getIC().getTile(x, z);
    }

    @Override
    protected IChunkProvider createChunkProvider() {

        return null;
    }

    @Override
    protected int func_152379_p() {

        return 0;
    }

    @Override
    public Entity getEntityByID(int p_73045_1_) {

        return null;
    }

    // Methods overriden to make this work

    @Override
    public Block getBlock(int x, int y, int z) {

        if (y == 63)
            return Blocks.stone;
        if (y != 64)
            return null;

        return QLBlocks.multipart;
    }

    @Override
    public int getBlockMetadata(int p_72805_1_, int p_72805_2_, int p_72805_3_) {

        return 0;
    }

    @Override
    public TileEntity getTileEntity(int x, int y, int z) {

        if (y != 64)
            return null;

        return getTile(x, z);
    }

    @Override
    public void markTileEntityChunkModified(int p_147476_1_, int p_147476_2_, int p_147476_3_, TileEntity p_147476_4_) {

    }

    @Override
    public void func_147453_f(int p_147453_1_, int p_147453_2_, int p_147453_3_, Block p_147453_4_) {

    }

    @Override
    public boolean isSideSolid(int x, int y, int z, ForgeDirection side) {

        return side == ForgeDirection.UP;
    }

    @Override
    public boolean isSideSolid(int x, int y, int z, ForgeDirection side, boolean _default) {

        return side == ForgeDirection.UP;
    }

    private static class FakeWorldSaveHandler implements ISaveHandler {

        @Override
        public WorldInfo loadWorldInfo() {

            return new WorldInfo(new NBTTagCompound());
        }

        @Override
        public void checkSessionLock() throws MinecraftException {

        }

        @Override
        public IChunkLoader getChunkLoader(WorldProvider p_75763_1_) {

            return null;
        }

        @Override
        public void saveWorldInfoWithPlayer(WorldInfo p_75755_1_, NBTTagCompound p_75755_2_) {

        }

        @Override
        public void saveWorldInfo(WorldInfo p_75761_1_) {

        }

        @Override
        public IPlayerFileData getSaveHandler() {

            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public File getWorldDirectory() {

            return null;
        }

        @Override
        public File getMapFileFromName(String p_75758_1_) {

            return null;
        }

        @Override
        public String getWorldDirectoryName() {

            return null;
        }

    }

}
