$.ajax('/assets/db.json')
.done(function(data){
    const language = 'en';
    const content = [];
    
    function addText(text, style){
        content.push(
            {
                text:text,
                style:style
            }
        );        
    }

    function addMainTitle(text){
        content.push(
            {
                text:text,
                style:'mainTitle'
            }
        );        
    }
    
    function getStyles(){
        return {
            mainTitle: {
                fontSize: 40,
                bold: true,
                alignment: 'center',
                margin:[0,200,0,0]
            },
            header:{
                fontSize:10,
                color:'gray'
            },
            center:{
                alignment:'center'
            },
            left:{
                alignment:'left'
            },
            right:{
                alignment:'right'
            },
            headerMarginTopLeft:{
                margin:[40,10,0,0]
            },
            headerMarginTopCenter:{
                margin:[0,10,0,5]
            },
            headerMarginTopRight:{
                margin:[0,10,40,0]
            },
            footerMarginBottom:{
                margin:[0,0,10,0]
            },
            title:{
                fontSize:30,
                bold:true,
                alignment:'right',
                margin:[0,0,0,20]
            },
            subtitle:{
                fontSize:20,
                bold:true,
                alignment:'right',
                margin:[0,10,0,20]                
            },
            jobtitle:{
                fontSize:15,
                bold:true,
                alignment:'left',
                margin:[0,20,0,0]
            },
            jobDetails:{
                fontSize:10,
                italics:true,
                alignment:'left',
                color:'gray',
                margin:[10,0,0,0]
            },
            jobDescription:{
                fontSize:12,
                alignment:'justify',
                margin:[10,0,10,0]
            },
            skilltitle:{
                fontSize:15,
                bold:true,
                alignment:'left',
                margin:[0,20,0,10]
            },
            skill:{
                fontSize:12,
                alignment:'center',
                margin:[0,0,0,5]
            },
            languagetitle:{
                fontSize:15,
                bold:true,
                alignment:'center',
                margin:[0,20,0,10]
            },
            language:{
                alignment:'center',
                fontSize:12,
                margin:[0,0,0,5]
            },
            projecttitle:{
                fontSize:15,
                bold:true,
                alignment:'left',
                margin:[0,20,0,0]
            },
            projectdetails:{
                fontSize:10,
                italics:true,
                alignment:'left',
                color:'gray',
                margin:[10,0,0,0]
            },
            projectdescription:{
                fontSize:12,
                alignment:'justify',
                margin:[10,0,10,0]
            }
        };
    }

    function breakPage(){
        content.push({text:'',pageBreak:'after'});
    }

    function buildAutoGenerationNotice(){
        var date = new Date();
        var year = date.getFullYear();
        var month = date.getMonth()+1;
        if (month<10) month = '0'+month;
        var day = date.getDate();
        if (day<10) day = '0'+day;
    
        var strDate = year+'-'+month+'-'+day;
        return data.pdf.auto[language] + " ("+strDate+")";
    }
    
    function addJob(job){
        addText(job.title[language],'jobtitle');

        var fromDate = new Date(job.from*1000);
        var fromYear = fromDate.getFullYear();
        var fromMonth = data.months[language][fromDate.getMonth()];

        if (job.to!=null){
            var toDate = new Date(job.to*1000);
            var toYear = toDate.getFullYear();
            var toMonth = data.months[language][toDate.getMonth()];
            addText(fromMonth+"/"+fromYear+" - "+toMonth+"/"+toYear, 'jobDetails');
        }else{
            addText(fromMonth+"/"+fromYear, 'jobDetails');
        }
        if (job.url!=null){
            addText(job.url,'jobDetails');
        }

        addText(job.description[language],'jobDescription');
    }

    function addExperience(){
        addText(data.cv.work.title[language],'subtitle');
        for (var e in data.cv.work.content){
            addJob(data.cv.work.content[e]);
        }
    }

    function addSkill(skill){
        addText(skill.title[language],'skilltitle');

        var columns = [];
        var currentColumn = null;

        for (var c in skill.content){
            if (c%5==0 && currentColumn!=null){
                columns.push(currentColumn);
                currentColumn = [];
            }else if (c==0){
                currentColumn = [];
            }

            currentColumn.push({text:skill.content[c],style:'skill'});
        }
        columns.push(currentColumn);

        content.push({
            columns:columns
        });


    }

    function addSkills(){
        addText(data.cv.tech.title[language],'subtitle');
        for (var s in data.cv.tech.content){
            addSkill(data.cv.tech.content[s]);
        }
    }

    function addLanguages(){
        addText(data.cv.languages.title[language],'subtitle');

        var columns = [];

        for (var l in data.cv.languages.content){
            var lng = data.cv.languages.content[l];
            columns.push([
                {text:lng.title[language],style:'languagetitle'},
                {text:lng.description[language],style:'language'}
            ]);
        }

        content.push({
            columns:columns
        });
    }

    function addCV(){
        addExperience();
        breakPage();
        addSkills();
        addLanguages();
        breakPage();
    }

    function addProject(project){
        addText(project.title[language], "projecttitle");
        if (project.urls!=null && project.urls.length>0){
            for (var u in project.urls){
                addText(project.urls[u].url, "projectdetails")
            }
        }

        var description;

        if (project.description[language]!=null){
            description = project.description[language];
        }else{
            var items = [];
            for (var i in project.items){
                items.push(project.items[i].title[language]);
            }
            description = items.join("  //  ");
        }
        addText(description, "projectdescription");
    }

    function addPortfolio(){
        addText(data.portfolio.title[language], "subtitle");
        for (var p in data.portfolio.projects){
            addProject(data.portfolio.projects[p]);
        }
    }

    function getHeader(){
        return [
            {
                columns:[
                    {
                        text:data.contact.google,style:['header','left','headerMarginTopLeft']
                    },
                    {
                        text:"http://ignacio.guerendiain.com.ar",style:['header','center','headerMarginTopCenter']
                    },
                    {
                        text:data.navbar.title[language],style:['header','right','headerMarginTopRight']
                    }
                ],
            },
            {
                text:data.contact.linkedin,style:['header','center']
            }
        ]
    }
    
    function getFooter(){
        return function(currentPage, pageCount){
            return [
                {
                    columns:[
                        {text:data.contact.google,style:['header','left','headerMarginTopLeft']},
                        {text:data.navbar.title[language],style:['header','center','headerMarginTopCenter']},
                        {
                            text:currentPage.toString() + ' / ' + pageCount,
                            style:['header','right','headerMarginTopRight']
                        },
                    ]
                },
                {
                    text:buildAutoGenerationNotice(),style:['header','center']
                }
            ];
        }
    }

    addCV();
    addPortfolio();

    var docDefinition = {
        content:content,
        header:getHeader(),
        footer:getFooter(),
        styles:getStyles()
    };

    console.log(docDefinition);

    pdfMake.createPdf(docDefinition).open();

    // pdfMake.createPdf(docDefinition).download('ignacio.guerendiain.pdf');
});




