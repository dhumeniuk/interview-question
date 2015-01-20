//==============================================================================
//                      UNCLASSIFIED
//==============================================================================
// Developed by L-3 Communications, Nova Engineering 2011
// Distribution authorized to U.S. Government agencies and their contractors;
// administrative/operational use, July 2011.
// Other requests for this software must be referred to:
// JUIAF
// ATTN:  DIA/DT
// 2460 Defense Way
// Charlottesville, VA 22911
//==============================================================================
//                       UNCLASSIFIED
//==============================================================================
package challenge1;

import java.util.Dictionary;
import java.util.Map;

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
    public static Object parseStringByType(final int type, final String value)
    {
        return null;
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
        return null;
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
     */
    public static Object parseStringsByType(final int type, final int cardinality, final String[] values)
    {
        return null;
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
        return null;
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
    	return null;
    }
}
