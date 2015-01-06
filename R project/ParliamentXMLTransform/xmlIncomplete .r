function (greekMPInformation) 
{
    require("XML") 
    fileList<-list.files(getwd())
    
    
    #For each conference file
    
    for (i in 1:length(fileList)){
        
        #initializing template and getting data
        xml<-xmlParse("<akomaNtoso>  <debate name=\"Conference\"> <meta>   <references source=\"#\">  </references> </meta> <preface> </preface> <debateBody>  </debateBody> </debate></akomaNtoso>")
        root<-xmlRoot(xml)
        date<-fileList[[i]]
        input<-read.csv(date)
        
        parlmembers<-unique(input$SpeakerID)
        parlmembers<-parlmembers[!is.na(parlmembers)]
        
        #Adding Parliament Members
        for (i in 1:length(parlmembers)){
            
            speakerID = parlmembers[i]
            name = greekMPInformation$name[greekMPInformation$id==parlmembers[i]]
            
            node<-newXMLNode(name = "TLCPerson", attrs = c(
                id = speakerID, 
                href = paste0("ontology/parlmember/s",speakerID),
                showAs = as.character(name)
            )
            )
            
            addChildren(root[[1]][[1]][[1]],node)
        }    
        #Adding Title
        addChildren(root[[1]][[2]],newXMLNode("docTitle",paste("Συνεδρίαση της βουλης των Ελληνων : ",date)))
        
        #Adding speeches
        speechBodies<-as.character(input$SpeechBody)
        ids<-as.character(input$SpeakerID)
        speakers<-as.character(input$Speaker)
        
        for (i in 1:nrow(input)){
            
            #Removing trash
            gsub("\\n","<br />",speechBodies[i])
			#gsub("\\([^)]+\\)","",speechBodies[i])			
            
            
            node<-newXMLNode(name = "speech",speechBodies[i], .children=newXMLNode(name="from",speakers[i]), attrs = c(
                if (!is.na(ids[i])){by = paste0("#",ids[i])},
                from = speakers[i]
            )
            )
            addChildren(root[[1]][[3]],node)
            
        }
		#Converting date from ddmmyyyy to yyyymmdd
		date<-as.Date(as.date(date,order="dmy"))
        #Saving file
        saveXML(xml,paste0(date,".xml"),encoding="utf-8")                
        
        
        
        
    }
    
    
    
    
}
