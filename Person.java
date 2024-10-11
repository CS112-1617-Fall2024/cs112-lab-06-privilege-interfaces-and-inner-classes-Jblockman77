public class Person implements Comparable
{
	class Identity {
		
		private String pronouns;
		private String background;

		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}
		
		public Identity() {
			this.pronouns = "They/them";
			this.background = "Unknown.";
		}

		@Override
		public boolean equals(Object other) {
			if (other == null || this.getClass() != other.getClass()) {
				return false;
			} else {
				Identity compare = (Identity) other;
				return this.pronouns.equals(compare.pronouns) && this.background.equals(compare.background);
			}
		}
		@Override
		public String toString() {
			return "Pronouns: " + pronouns + "my Background is: \n" + background;
		}
	}

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS = "They/them";
	public static final String DEFAULT_BACKGROUND = "Unknown";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name, pronouns, background;
	private Identity story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		this.setAll(name, pronouns, background, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.pronouns, original.background, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String pronouns, String background, int privilege) {
		this.name = name;
		this.pronouns = pronouns;
		this.background = background;
		this.privilege = privilege;
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}

	public String getPronouns() {
		return pronouns;
	}

	public String getBackground() {
		return background;
	}
	
	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person))) {
		    return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/

	@Override
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o;
			if (this.getPrivilege() > p.getPrivilege()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return 1;
		}
	}
}