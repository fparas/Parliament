shinyUI(fluidPage(
  titlePanel("Greek Parliament analysis project Testing"),
   fluidRow(
      column( 
          selectInput("parlMember", 
                      "Ομιλιτής", 
                      c("All", 
                        unique(as.character(greekMpInformation$name))))
      ),
      column( 
          selectInput("politicalParty", 
                      "Κόμμα", 
                      c("All", 
                        unique(greekMpInformation$politicalParty)))
      ),
      column( 
          selectInput("province", 
                      "Εκλογική περιφέρεια", 
                      c("All", 
                        unique(greekMpInformation$province)))
      ),
	  
	  column(
	  dateRangeInput('dateRange',
      label = 'Date range input: yyyy-mm-dd',
      start = Sys.Date() - 2, end = Sys.Date() + 2
    )
	  
	  
    )),	
  sidebarLayout(
    sidebarPanel( "sidebar panel"),
    mainPanel("main panel")
  )

)
)
