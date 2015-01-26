package challenge1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import org.osgi.service.metatype.AttributeDefinition;

/**
 * Utilities to make it easier to work with configurations from the ConfigurationAdmin service.
 */
public final class ConfigurationUtils
{
    
	/**
     * Private constructor to prevent instantiation.
     */
    private ConfigurationUtils()
    {
        // do nothing
    }

    /**
     * Converts String attribute value (from a metatype attribute definition) to what it is specified to be.
     * 
     * @param type
     *            the {@link AttributeDefinition} type
     * @param value
     *            the value that this attribute represents
     * @return parsed string of the desired type
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    
    public static Object parseStringByType(final int type, final String value)
    {
    	Class paramType = String.class;
    	    	   	   			
    	if( type == AttributeDefinition.CHARACTER )
    		paramType = char.class;
    	
    	try {
    		Class cls = convertToClassType(type);
    		Constructor constructor = cls.getConstructor(new Class[]{paramType});
			try {
				return constructor.newInstance( (paramType == char.class) ? value.charAt(0) : value);
				
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				
				return null;
			}
			
		} catch (NoSuchMethodException | SecurityException e) {
			
			return null;
		}
    	
	}		
			
	/**
     * Method that converts the integer type stored in an attribute definition to a the appropriate class type.
     * 
     * @param type
     *          integer that represents the class type of the attribute definition.
     * @return
     *          the class type the integer represents.
     */
    public static Class<?> convertToClassType(final int type)
    {
    	switch(type){
    		case AttributeDefinition.STRING:
    		case AttributeDefinition.PASSWORD: //In the "clear" for this exercise... 
    		    return String.class;
    		   		
    		case AttributeDefinition.LONG:
    			return Long.class;
    		    			
    		case AttributeDefinition.INTEGER:
    			return Integer.class;
    			
    		case AttributeDefinition.SHORT:
    			return Short.class;
    		
    		case AttributeDefinition.CHARACTER:
    			return Character.class;
    		
    		case AttributeDefinition.BYTE:
    			return Byte.class;
    		    	    
    		case AttributeDefinition.DOUBLE:
    			return Double.class;
    			
    		case AttributeDefinition.FLOAT:
    			return Float.class;
    			
    		case AttributeDefinition.BOOLEAN:
    			return Boolean.class;
    			
    		default:
    			return null;
    	}
    }
    	
    
    /**
     * Converts String[] attribute values (from MetaType attribute definitions) to what it is specified to be.
     * 
     * See {@link AttributeDefinition#getCardinality()} for information.
     * 
     * @param type
     *            the {@link AttributeDefinition} type
     * @param cardinality
     *            the {@link AttributeDefinition} cardinality
     * @param values
     *            the value that this attribute represents
     * @return parsed string of the desired type
     * 
     * 
     * 	  x = Integer.MIN_VALUE    no limit, but use Vector
	 *    x &lt; 0                 -x = max occurrences, store in Vector
	 *    x &gt; 0                  x = max occurrences, store in array []
	 *    x = Integer.MAX_VALUE    no limit, but use array []
	 *    x = 0                    1 occurrence required
     */
    
    @SuppressWarnings({"unchecked"})
    public static Object parseStringsByType(final int type, final int cardinality, final String[] values)
    {
        if(cardinality == Integer.MIN_VALUE){
        	return getVector(type, values.length, values);
        
        }else if(cardinality < 0){
        	return getVector(type, Math.abs(cardinality), values);
        	
        }else if(cardinality > 0){
        	return ((Vector<Object>)getVector(type, cardinality, values)).toArray();
        	
        }else if(cardinality == Integer.MAX_VALUE){
        	return ((Vector<Object>)getVector(type, values.length, values)).toArray();
        
        }else if(cardinality == 0){
        	return ((Vector<Object>)getVector(type, 1, values)).toArray()[0];
        	
        }else
        	return null;
    }

    /**
     * Helper function that builds a vector based on the Attribute Definition type passed in. 
     * @param type
     * 			 The {@link AttributeDefinition} type.
     * @param length
     * 			  The length that the vector should be.
     * @param values
     * 			  The value that this attribute represents.
     * @return
     * 	Returns a reference to the created "typed" vector.
     */
    public static Object getVector(final int type, final int length, final String[] values){
    	Vector<Object> vector = new Vector<>();
    	
    	for(int i = 0; (i < length)&&(i < values.length); i++)
    			vector.add(parseStringByType(type, values[i]));
    	
    	return vector;
    }
    
    /**
     * Create a {@link Map} from the incoming {@link Dictionary}.
     * 
     * @param <K>
     *      type of the key for this Dictionary
     * @param <V>
     *      type of the value for this Dictionary
     * @param props
     *      dictionary of properties to convert
     * @return
     *      map of converted from the dictionary
     */
    public static <K, V> Map<K, V> convertDictionaryPropsToMap(final Dictionary<K, V> props)
    {
    	Map<K, V> map = new HashMap<>(props.size());
    	
        for(Enumeration<K> keys = props.keys(); keys.hasMoreElements();){
        	K key = keys.nextElement();
        	map.put(key, props.get(key));
        }
    	
        return map;
    }
    
    /**
     * Create a clone of the incoming {@link Dictionary}.  Elements are the same reference, but the dictionary itself 
     * is a new instance.
     * 
     * @param props
     *      dictionary of properties to clone
     * @return
     *      clone of the dictionary
     */
    public static Dictionary<String, Object> cloneDictionary(final Dictionary<String, Object> props)
    {
    	Dictionary<String, Object> clone = new Hashtable<String, Object>(props.size());
    	
    	for(Enumeration<String> keys = props.keys(); keys.hasMoreElements();){
    		String key = keys.nextElement();
        	clone.put(key, props.get(key));
        }
       	
    	return clone;
    }
}
