package io.github.Leonardo0013YT.UltraSkills.adapters;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class IPlayerIslandAdapter implements JsonSerializer, JsonDeserializer {
  private static final String CLASSNAME = "IPlayerIsland";
  
  private static final String DATA = "Data";
  
  public Object deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    JsonPrimitive prim = (JsonPrimitive)jsonObject.get("IPlayerIsland");
    String className = prim.getAsString();
    Class<?> klass = getObjectClass(className);
    return jsonDeserializationContext.deserialize(jsonObject.get("Data"), klass);
  }
  
  public JsonElement serialize(Object jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("IPlayerIsland", jsonElement.getClass().getName());
    jsonObject.add("Data", jsonSerializationContext.serialize(jsonElement));
    return (JsonElement)jsonObject;
  }
  
  public Class<?> getObjectClass(String className) {
    try {
      return Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new JsonParseException(e.getMessage());
    } 
  }
}
