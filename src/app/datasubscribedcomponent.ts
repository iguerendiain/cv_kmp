import { Component } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { DataService, LANGUAGE_CHANGED_EVENT, CVDATA_CHANGED_EVENT } from './data.service';

@Component({})
export abstract class DataSubscribedComponent{
    private subscription:Subscription;

    constructor(private data:DataService){
        this.subscription = this.data.getObservable().subscribe(
            ev => this.onEventReceived(ev)
        );
    }

    private onEventReceived(event){
        var ev = event.event;

        switch(ev){
            case LANGUAGE_CHANGED_EVENT:
                this.onLanguageChanged(this.data.getLanguage());
            break;
            case CVDATA_CHANGED_EVENT:
                this.onCVDataChanged(this.data.getData());
            break;
        }
    }

    getLanguage():string{
        return this.data.getLanguage();
    }

    getCVData():any{
        return this.data.getData();
    }

    setDataLanguage(lang:string):void{
        this.data.setLanguage(lang);
    }

    abstract onLanguageChanged(language:string):void;
    abstract onCVDataChanged(cvData:any):void;
}
