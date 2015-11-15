package com.proj1.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.proj1.model.Item;

public class ItemAdapter implements JsonSerializer<Item> {
	@Override
	public JsonElement serialize(Item item, Type type, JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
		String imageURLPrefix = "files/image?fileName=";
		jsonObject.addProperty("itemCode", item.getItemCode());
		jsonObject.addProperty("categoryId", item.getCategory().getCategoryId());
		jsonObject.addProperty("itemName", item.getItemName());
		jsonObject.addProperty("itemDesc", item.getItemDesc());
		jsonObject.addProperty("price", item.getPrice());
		jsonObject.addProperty("fileName", imageURLPrefix+item.getFileName());
		return jsonObject;
	}
}
