public class Fruit implements Comparable 
{
    private String name;
    public Fruit(String name)
    {
        this.name = name;
    }

    String getName()
    {
        return name;
    }
   
    

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Fruit other = (Fruit) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object arg0) {
		return name.compareTo(((Fruit)arg0).getName());
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}
    
	
	
}