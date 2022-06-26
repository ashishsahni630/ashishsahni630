package Info;
import java.util.*;
import java.io.*;
public class Infarmation implements Serializable{
	String User_Name;
	int User_Number;
	String User_City;
	
	
	
	public Infarmation(String user_Name, int user_Number, String user_City) {
		User_Name = user_Name;
		User_Number = user_Number;
		User_City = user_City;
	}

	

	@Override
	public String toString() {
		return User_Name+" "+User_Number+" "+User_City;
	}

		public static void main(String [] args) throws Exception{
			
			int choice=-1;
			Scanner sc= new Scanner(System.in);
			Scanner sc1= new Scanner(System.in);
			File file= new File("Infarmation.txt");
			ArrayList<Infarmation> UI= new ArrayList<Infarmation>();
			ObjectOutputStream Sto= null;
			ObjectInputStream Stor= null;
			       ListIterator li= null;
			
			if(file.isFile()) {
				Stor=new ObjectInputStream(new FileInputStream (file));
				UI= (ArrayList<Infarmation>)Stor.readObject();
				Stor.close();
			}
			
			do {
				System.out.println("1: Insert");
				System.out.println("2: Display");
				System.out.println("3: Search");
				System.out.println("4: Delete");
				System.out.println("0: Exit");
				System.out.println("Enter Your Choice: ");
				choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("How meny User: ");
					int n= sc.nextInt();
					for(int i=0; i<n; i++) {
					
					System.out.print("Enter User_Name: ");
					String User_Name= sc1 .nextLine();
					System.out.print("Enter User_Number: ");
					int User_Number= sc.nextInt();
					System.out.print("Enter User_City: ");
					String User_City= sc1.nextLine();
					UI.add(new Infarmation(User_Name,User_Number,User_City));
					}
					Sto = new ObjectOutputStream(new FileOutputStream(file));
					Sto.writeObject(UI);
					Sto.close();
				break;
				case 2:
					if(file.isFile()) {
						Stor=new ObjectInputStream(new FileInputStream (file));
						UI= (ArrayList<Infarmation>)Stor.readObject();
						Stor.close();
					System.out.println("*********************************");
					li=UI.listIterator();
				while(li.hasNext())
					System.out.println(li.next());
					System.out.println("*********************************");
					}else {
						System.out.println("File is not Exist----!");
					}
				break;	
				
				case 3:
					if(file.isFile()) {
						Stor=new ObjectInputStream(new FileInputStream (file));
						UI= (ArrayList<Infarmation>)Stor.readObject();
						Stor.close();
						
					boolean found= false;
					System.out.println("Enter User_Number To Search: ");
					int User_Number=sc.nextInt();
					System.out.println("*********************************");
					li=UI.listIterator();
				while(li.hasNext()) {
					Infarmation U= (Infarmation)li.next();
				if(U.User_Number== User_Number) {
					System.out.println(U);
					found= true;
					}
				}
				if(!found)
					System.out.println("Record is not found-----------!");
					System.out.println("*********************************");	
					}else {
						System.out.println("File not Exist---!");
					}
				break;
				case 4:
					if(file.isFile()) {
						Stor=new ObjectInputStream(new FileInputStream (file));
						UI= (ArrayList<Infarmation>)Stor.readObject();
						Stor.close();
						
					boolean found= false;
					System.out.print("Enter User_Number To Delet: ");
					int User_Number=sc.nextInt();
					System.out.println("*********************************");
					li=UI.listIterator();
				while(li.hasNext()) {
					Infarmation U= (Infarmation)li.next();
				if(U.User_Number== User_Number) {
					li.remove();;
					found= true;
					}
				}
				if(found) {
					Sto = new ObjectOutputStream(new FileOutputStream(file));
				       Sto.writeObject(UI);
				       Sto.close();
				     System.out.println("The data is deleted Succesfully----!");
				}
				else {
					System.out.println();
				}
					
					System.out.println("*********************************");	
					}else {
						System.out.println("File not Exist---!");
					}
				break;
				}
				
			}while(choice !=0);
		
		}

	}


