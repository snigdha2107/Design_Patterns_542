package myComputerManual.dataStore;

public abstract class Component {
    
    private String name;
    private String desc;
    private int pages;
    private int listOfFigures;
    private String glossary;
    
  public String getName() { return name; }
  public String getDescription() { return desc; }
  public int getPages() { return pages; }
  public int getListOfFigures() { return listOfFigures; }
  public String getGlossary() { return glossary; }
  
  public void setDescription(String description)
  {
      this.desc = description;
  }
  
  public void setName(String name)
  {
      this.name = name;
  }
  
  public void setPages(int noOfPages)
  {
      this.pages = noOfPages;
  }
  
  public void setListOfFigures(int lof)
  {
      this.listOfFigures = lof;
  }
  
  public void setGlossary(String glos)
  {
      this.glossary = glos;
  }
}
