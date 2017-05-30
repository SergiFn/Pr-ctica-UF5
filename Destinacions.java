
public class Destinacions {
	private String id;
	private String Continent;
	private String Pais;
	private String Capital;
	private String Ciutat;
	private String Poblacio;
	private String CP;
	private String Platja;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	public String getPais() {
		return Pais;
	}
	public void setPais(String pais) {
		Pais = pais;
	}
	public String getCapital() {
		return Capital;
	}
	public void setCapital(String capital) {
		Capital = capital;
	}
	public String getCiutat() {
		return Ciutat;
	}
	public void setCiutat(String ciutat) {
		Ciutat = ciutat;
	}
	public String getPoblacio() {
		return Poblacio;
	}
	public void setPoblacio(String poblacio) {
		Poblacio = poblacio;
	}
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public String getPlatja() {
		return Platja;
	}
	public void setPlatja(String platja) {
		Platja = platja;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CP == null) ? 0 : CP.hashCode());
		result = prime * result + ((Capital == null) ? 0 : Capital.hashCode());
		result = prime * result + ((Ciutat == null) ? 0 : Ciutat.hashCode());
		result = prime * result + ((Continent == null) ? 0 : Continent.hashCode());
		result = prime * result + ((Pais == null) ? 0 : Pais.hashCode());
		result = prime * result + ((Platja == null) ? 0 : Platja.hashCode());
		result = prime * result + ((Poblacio == null) ? 0 : Poblacio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Destinacions other = (Destinacions) obj;
		if (CP == null) {
			if (other.CP != null)
				return false;
		} else if (!CP.equals(other.CP))
			return false;
		if (Capital == null) {
			if (other.Capital != null)
				return false;
		} else if (!Capital.equals(other.Capital))
			return false;
		if (Ciutat == null) {
			if (other.Ciutat != null)
				return false;
		} else if (!Ciutat.equals(other.Ciutat))
			return false;
		if (Continent == null) {
			if (other.Continent != null)
				return false;
		} else if (!Continent.equals(other.Continent))
			return false;
		if (Pais == null) {
			if (other.Pais != null)
				return false;
		} else if (!Pais.equals(other.Pais))
			return false;
		if (Platja == null) {
			if (other.Platja != null)
				return false;
		} else if (!Platja.equals(other.Platja))
			return false;
		if (Poblacio == null) {
			if (other.Poblacio != null)
				return false;
		} else if (!Poblacio.equals(other.Poblacio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Destinacions [id=" + id + ", Continent=" + Continent + ", Pais=" + Pais + ", Capital=" + Capital
				+ ", Ciutat=" + Ciutat + ", Poblacio=" + Poblacio + ", CP=" + CP + ", Platja=" + Platja + "]";
	}
	public Destinacions(String id, String continent, String pais, String capital, String ciutat, String poblacio,
			String cP, String platja) {
		super();
		this.id = id;
		Continent = continent;
		Pais = pais;
		Capital = capital;
		Ciutat = ciutat;
		Poblacio = poblacio;
		CP = cP;
		Platja = platja;
	}
	
	
}
