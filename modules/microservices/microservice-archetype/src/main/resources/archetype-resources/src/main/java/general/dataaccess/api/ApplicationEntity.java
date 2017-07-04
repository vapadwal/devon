#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.general.dataaccess.api;

import net.sf.mmm.util.entity.api.MutableGenericEntity;

/**
 * This is the abstract interface for a {@link MutableGenericEntity} of this application. We are using {@link Long} for
 * all {@link ${symbol_pound}getId() primary keys}.
 *
 */
public abstract interface ApplicationEntity extends MutableGenericEntity<Long> {

}