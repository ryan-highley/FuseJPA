package configuration.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the configuration_values database table.
 * 
 */
@Entity
@Table(name="configuration_values")
@NamedQuery(name="ConfigurationValue.findAll", query="SELECT c FROM ConfigurationValue c")
public class ConfigurationValue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="configuration_value_id", insertable=false, updatable=false)
	private Long configurationValueId;

	private String key;

	private String value;

	//bi-directional many-to-one association to Configuration
	@ManyToOne
	@JoinColumn(name="configuration_id")
	private Configuration configuration;

	public ConfigurationValue() {
	}

	public Long getConfigurationValueId() {
		return this.configurationValueId;
	}

	public void setConfigurationValueId(Long configurationValueId) {
		this.configurationValueId = configurationValueId;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Configuration getConfiguration() {
		return this.configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}