/*
 * MIT License
 *
 * Copyright (c) 2020 TerraForged
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.terraforged.mod.biome.map.set;

import com.terraforged.engine.cell.Cell;
import com.terraforged.fm.GameContext;
import com.terraforged.mod.biome.map.BiomeMap;
import com.terraforged.mod.biome.map.defaults.DefaultBiomes;
import com.terraforged.mod.biome.utils.TempCategory;
import net.minecraft.world.biome.Biome;

import java.util.List;
import java.util.Map;

public class WetlandSet extends TemperatureSet {

    private final BiomeMap fallback;

    public WetlandSet(Map<TempCategory, List<Biome>> map, BiomeMap fallback, GameContext context) {
        super(map, DefaultBiomes.WETLAND, context);
        this.fallback = fallback;
    }

    @Override
    public Biome getBiome(Cell cell) {
        Biome biome = super.getBiome(cell);
        if (biome == null) {
            return fallback.getLand(cell);
        }
        return biome;
    }
}
