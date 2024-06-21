package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 7, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(6, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        
    }
    
    
//    @Test
//    void foo(int sellin, int quality, int sellinOut, int qualityOut) {
//        Item[] items = new Item[] { new Item("foo", sellin, quality) };
//        GildedRose app = new GildedRose(items);
//        app.updateQuality();
//        assertEquals("foo", app.items[0].name);
//        assertEquals(sellinOut, app.items[0].sellIn);
//        assertEquals(qualityOut, app.items[0].quality);
//    }
    
    
    @Test
    void AgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
    }
    
    
    @Test
    void Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @ParameterizedTest(name = "SellIn: {0} -> {2}, Quality: {1} -> {3}")
	@CsvSource({
		"2, 0, 1, 1",
		"-1, 48, -2, 50",
		"2, 50, 1, 50",
		"-2, 49, -3, 50",
		"1, 1, 0, 2",
		})
    
    
	void productAgedBrieTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Aged Brie";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
    
	@ParameterizedTest(name = "SellIn: {0} -> {2}, Quality: {1} -> {3}")
	@CsvSource({
		"1, 80, 1, 80",
		"0, 1, 0, 1",
		"-1, 1, -1, 1",
		})
	
	void productSulfurasTest(int sellIn, int quality, int sellInResult, int qualityResult) {
		String name = "Sulfuras, Hand of Ragnaros";
		Item product = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[] { 
        		product
        });
        app.updateQuality();
        assertAll(name,
        		() -> assertEquals(name, product.name, "name"),
        		() -> assertEquals(sellInResult, product.sellIn, "sellIn"),
        		() -> assertEquals(qualityResult, product.quality, "quality")
        		);
	}
	

	
	

}
