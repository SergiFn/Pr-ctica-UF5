
public class PuntsInteres {
	private String id;
	private String nom;
	private String descripcio;
	private String tipus;
	private String activitats;
	
	public PuntsInteres(){
		super();
	}
	public PuntsInteres(String id, String nom, String descripcio, String tipus, String activitats) {
		super();
		this.id = id;
		this.nom = nom;
		this.descripcio = descripcio;
		this.tipus = tipus;
		this.activitats = activitats;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public String getTipus() {
		return tipus;
	}
	public void setTipus(String tipus) {
		this.tipus = tipus;
	}
	public String getActivitats() {
		return activitats;
	}
	public void setActivitats(String activitats) {
		this.activitats = activitats;
	}
	@Override
	public String toString() {
		return "PuntsInteres [id=" + id + ", nom=" + nom + ", descripcio=" + descripcio + ", tipus=" + tipus
				+ ", activitats=" + activitats + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activitats == null) ? 0 : activitats.hashCode());
		result = prime * result + ((descripcio == null) ? 0 : descripcio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((tipus == null) ? 0 : tipus.hashCode());
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
		PuntsInteres other = (PuntsInteres) obj;
		if (activitats == null) {
			if (other.activitats != null)
				return false;
		} else if (!activitats.equals(other.activitats))
			return false;
		if (descripcio == null) {
			if (other.descripcio != null)
				return false;
		} else if (!descripcio.equals(other.descripcio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (tipus == null) {
			if (other.tipus != null)
				return false;
		} else if (!tipus.equals(other.tipus))
			return false;
		return true;
	}
	
	
}
