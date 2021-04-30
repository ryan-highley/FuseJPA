package configuration.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the configuration database table.
 * 
 */
@Entity
@NamedQuery(name="Configuration.findAll", query="SELECT c FROM Configuration c")
public class Configuration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="configuration_id", insertable=false, updatable=false)
	private Long configurationId;

	@Column(name="key_field_names")
	private String keyFieldNames;

	private String name;

	@Column(name="value_field_names")
	private String valueFieldNames;

	//bi-directional many-to-one association to ConfigurationValue
	@OneToMany(mappedBy="configuration")
	private List<ConfigurationValue> configurationValues;

	public Configuration() {
	}

	public Long getConfigurationId() {
		return this.configurationId;
	}

	public void setConfigurationId(Long configurationId) {
		this.configurationId = configurationId;
	}

	public String getKeyFieldNames() {
		return this.keyFieldNames;
	}

	public void setKeyFieldNames(String keyFieldNames) {
		this.keyFieldNames = keyFieldNames;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValueFieldNames() {
		return this.valueFieldNames;
	}

	public void setValueFieldNames(String valueFieldNames) {
		this.valueFieldNames = valueFieldNames;
	}

	public List<ConfigurationValue> getConfigurationValues() {
		return this.configurationValues;
	}

	public void setConfigurationValues(List<ConfigurationValue> configurationValues) {
		this.configurationValues = configurationValues;
	}

	public ConfigurationValue addConfigurationValue(ConfigurationValue configurationValue) {
		getConfigurationValues().add(configurationValue);
		configurationValue.setConfiguration(this);

		return configurationValue;
	}

	public ConfigurationValue removeConfigurationValue(ConfigurationValue configurationValue) {
		getConfigurationValues().remove(configurationValue);
		configurationValue.setConfiguration(null);

		return configurationValue;
	}

}