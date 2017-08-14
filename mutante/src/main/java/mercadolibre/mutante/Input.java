
package mercadolibre.mutante;

import org.codehaus.jackson.annotate.JsonProperty;

public class Input {
	
	@JsonProperty("dna")
	private String[] data = null;

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}

}