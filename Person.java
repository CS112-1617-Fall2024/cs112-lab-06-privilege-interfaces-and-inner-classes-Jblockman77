/**
 * Person and Identity class.
 * 
 * @author Rafail Lishman
 * @version 2
 */
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
		/**
		  * Equals, overrides orginial equals method and compares if the object given is the same as the object being compared to.
		  *
		  * @param Object

 		 * @return Boolean
  		*/

		@Override
		public boolean equals(Object other) {
			if (other == null || this.getClass() != other.getClass()) {
				return false;
			} else {
				Identity compare = (Identity) other;
				return this.pronouns.equals(compare.pronouns) && this.background.equals(compare.background);
			}
		}
			/**
  			* ToString
  			*
  			* @param None
			*
  			* @return String of a person's story
  			*/ 
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
		this.story = new Identity(pronouns, background);
	}	
	public Person() {
		this(DEFAULT_NAME, DEFAULT_PRONOUNS, DEFAULT_BACKGROUND, DEFAULT_PRIVILEGE);
		this.story = new Identity(DEFAULT_PRONOUNS, DEFAULT_BACKGROUND);
	}
	
	public Person(Person original) {
		if (original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.pronouns, original.background, original.privilege);
			this.story = new Identity(original.pronouns, original.background);
		}
	}
	

	// MUTATORS/SETTERS

		/**
		* setName
		* 
		* @param String name
		
		* @return Nothing, sets the name of a person
		*/
	public void setName(String name) {
		this.name = name;
	}
		/**
		* setPronouns
		* 
		* @param String Pronouns
		
		* @return Nothing, sets the Pronouns of a person
		*/

	public void setPronouns(String pronouns) {
		this.pronouns = pronouns;
	}
		/**
		* setBackground
		* 
		* @param String background
		
		* @return Nothing, sets the background of a person
		*/

	public void setBackground(String background) {
		this.background = background;
	}
		/**
		* setPrivilege
		* 
		* @param int privilege
		
		* @return Nothing, sets the priviledge of a person
		*/

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

		/**
		* setALL
		* 
		* @param String name, String Pronouns, String Background, int privilege
		
		* @return Nothing, sets everything of a class
		*/

	public void setAll(String name, String pronouns, String background, int privilege) {
		this.name = name;
		this.pronouns = pronouns;
		this.background = background;
		this.privilege = privilege;
		this.story = new Identity(pronouns, background);
	}

	// ACCESSORS / GETTERS

	/**
	* getName
	* 
	* @param None
	
	* @return the Name of a person
	*/
	public String getName() {
		return this.name;
	}

	/**
  * getPronouns
  * 
  * @param None

  * @return Returns the pronouns of a perosn
  */

	public String getPronouns() {
		return pronouns;
	}

	/**
  * getBackground
  * 
  * @param None

  * @return the background of a person.
  */

	public String getBackground() {
		return background;
	}

	/**
  * getPriviledge
  * 
  * @param None

  * @return the privilege of a person
  */
	
	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS

	/**
  * ToString
  *
  * @param None

  * @return String of a persons story and priviledge points
  */ 

	@Override
	public String toString()
	{
		return "My name is " + this.name + " and " + this.story + "\n"
				+ "According to this calculator I ended up with " + this.privilege + " estimated privilege points";
	}
	
	/**
  * Equals, overrides orginial equals method and compares if the object given is the same as the object being compared to.
  *
  * @param Object

  * @return Boolean
  */
	
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

	/**
	* CompareTo
	* 
	* @param Another object
	
	* @returns the difference between your person's privilege and another person privilege (int)
	*/
  
	@Override
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person p = (Person) o;
			return this.getPrivilege() - p.getPrivilege();
		}
		else {
			throw new IllegalArgumentException("Cannot be compared to a person");
		}
	}
}