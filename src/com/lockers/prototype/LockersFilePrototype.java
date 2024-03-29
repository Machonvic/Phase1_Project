package com.lockers.prototype;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class LockersFilePrototype {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputA=0;
		String inputSearch;
		String inputDelete;
		String inputFile;
		double inputB=0;
	
		System.out.println("Welcome to LockersMe.com");
		System.out.println("Developer Name: Victor Hongo\n");
		System.out.println("-----------------------------");
		
		LockersFilePrototype fm=new LockersFilePrototype();
		
		fm.createDirectory();
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
									
		while(true) {
			
			System.out.println("Please Select below Options by entering number between 1 and 3:"
					+ "\n\t 1.Retrive Files"
					+ "\n\t 2.More business operations"
					+ "\n\t 3.Close Program");
			
				   
		    do {
		        try {
		             inputA = input.nextInt();
		        } catch (InputMismatchException e) {
		            System.out.println("Invalid input. Enter a number between 1 and 3 ");
		        }
		        input.nextLine(); // clears the buffer
		    } while (inputA <= 0);
		    
		    
		  
			
			if (inputA==1) {
				 
				System.out.println("\nList of Files");
				fm.retrieveFiles(); 
				System.out.println("");
			}
			else if (inputA==2) {
				
				while(true) {
					fm.businessOperationOptions();
					do {
				        try {
				        	inputB = input.nextDouble();
					        	if(inputB<2.1 ||inputB>2.4 )
					        	{
					        		System.out.println("Invalid input. Enter a number between 2.1 and 2.4 ");
					        		}
				        } catch (InputMismatchException e) {
				            System.out.println("Invalid input. Enter a number between 2.1 and 2.4 ");
				        }
				        input.nextLine(); // clears the buffer
				        
				    } while (inputB <= 0);
					
										
					if (inputB==2.1) {
						System.out.println("What is the file name?");
						inputFile=input.next();
						

						
				    	
				    	fm.addFile(inputFile,fm.filePathDir);
					}
					else if(inputB==2.2) {
						System.out.println("Enter the name of the file you want to delete:");
						inputDelete=input.next();
						fm.deleteFile(inputDelete,fm.filePathDir);
					}
					else if(inputB==2.3) {
						
						System.out.println("Please enter filename to search.");
						inputSearch=input.next();
						System.out.println("File Being Searched is: "+ inputSearch);
						
						if(inputSearch != null && !inputSearch.isEmpty()) {
							
							fm.searchFile(inputSearch,fm.folder);
						}
						
												
					}
					else if (inputB==2.4) {
						System.out.println("");//Back to main menu
						break;
					}
				}
				
			}else if(inputA==3) {
				
			System.out.println("Program Closed");
				break;
			}
		   
			
			
					
		}    
		
		

	}

	
	/*File Managing Methods*/
	
	String filePathDir="C:\\\\Project_Phase1\\";
	File folder = new File("C:\\\\Project_Phase1\\");
	
	
	public void createDirectory() {
		  //Creating the directory
	      
	      File theDir = new File("C:\\\\Project_Phase1\\");
	      if (!theDir.exists()){
	          theDir.mkdirs();
	      }
	}
	   //File menu to selection various operations
	
	   public int FileOperationOptions() {

	        int selection;
	        
	      
	        try (Scanner input = new Scanner(System.in)) {
				System.out.println("Please Select below Options:"
						+ "\n\t 1.Retrive Files"
						+ "\n\t 2.More business operations"
						+ "\n\t 3.Close Program");
					selection = input.nextInt();
				
			     }
  
	        	  return selection;         
	    }
	   
	
	  //Retrieving files in ascending order
		public void retrieveFiles() {
	          	       
		   File[] listOfFiles = folder.listFiles();
		   
		   
		      if (listOfFiles.length==0) {
		    	  System.out.println("No File Found");
		    	  }
		   
			  for (int i = 0; i < listOfFiles.length; i++) {
					      
				  if (listOfFiles[i].isFile()) {
					  
					Arrays.sort(listOfFiles);
				    System.out.println(i+1+"." + listOfFiles[i].getName());
				   }
				}
		}
		
		
		public void businessOperationOptions() {
	             
	             	System.out.println("Please Select Business Operations Below:"
						+ "\n\t 2.1. Add Files"
						+ "\n\t 2.2. Delete Files"
						+ "\n\t 2.3. Search Files"
						+ "\n\t 2.4. Go back to main menu");
					
				    }
		
		
	    public void searchFile(String name,File file)
	    {
	        String fileFound=null;
	        
	    	File[] list = file.listFiles();
	        if(list!=null)
	        for (File fil : list)
	        {
	            if (fil.isDirectory())
	            {
	            	searchFile(name,fil);
	            }
	            else if (name.equals(fil.getName()))//checks case sensitivity
	            {
	                	            	
	            	fileFound=fil.getName();
	            	
	            		            }
	        }
	        
	          if(fileFound!=null) {
	        	  
	        	  System.out.println("Found file: "+ fileFound);
	        	  System.out.println(" ");
	          }else
	          {
	        	  System.out.println("File not Found");
	        	  System.out.println(" ");
	          }
	          
	          
	    }
	    
	    public void deleteFile(String fileName, String filePathDir) {
	    	
	    	//String filePath=filePathDir+fileName;
	    		
	
	    	try  
	    	{         
	    		
	    	    		
	    	File f=new File(filePathDir+fileName);          //file to be delete 
	    	
	    	if(f.exists()) { // checks case sensitivity
		    	
	    	
			    	if(f.delete())                    
			    	{  
			    			System.out.println(f.getName() + " deleted successfuly");   //getting and printing the file name  
			    	}  
			    	else  
			    	{  
			    			System.out.println("failed to delete");  
			    	}  
			    	
	    	}
	    	else {
	    		System.out.println("File does not exist");  
	    	}
	    	}  
	    	catch(Exception e)  
	    	{  
	    		e.printStackTrace();  
	    	}  
	    	
	    }
	    
	    public void addFile(String fileName,String fileDir) {
	    	
	    	 File f2=new File (fileDir+fileName);
	    	if (f2.exists()){
	    		
	    		System.out.println("file already exists");
	    	}
	    	else {
	    		    	
			    	try {
						f2.createNewFile();
						System.out.println("file created");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    	}
	    	
	    	/*
	        try{    
	            FileWriter fw=new FileWriter(fileDir+fileName);    
	            fw.write(writeContent);    
	            fw.close();    
	           }catch(Exception e)
	        
	        {
	        	   System.out.println(e);
	        	   
	        	   }    
	           System.out.println("Content Written");
	           */    
	      }  
	    	
	
}
