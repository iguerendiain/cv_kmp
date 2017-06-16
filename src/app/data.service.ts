import { Component,Injectable } from '@angular/core'
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http'
import { Subject } from 'rxjs/Subject';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

export const LANGUAGE_CHANGED_EVENT = "languageChanged";
export const CVDATA_CHANGED_EVENT = "cvDataChangedEvent";

@Injectable()
export class DataService{

    private subscriber = new Subject<any>();

    cvData = null;
    currentLanguage = null;

    constructor(private http:Http){}

    downloadData():Observable<any>{
        return this.http.get("assets/db.json").map(res => res.json());
    }

    setData(data):void{
        this.cvData = data;
        this.autoSetLanguage();
        this.sendEvent(CVDATA_CHANGED_EVENT);
    }

    getData():any{
        return this.cvData;
    }

    autoSetLanguage():void{
        let defaultLanguage = this.cvData.defaultLanguage;
        let browserLanguage = null;
        let rawBrowserLanguage = navigator.language;

        if (rawBrowserLanguage!=null && rawBrowserLanguage.length > 0 && rawBrowserLanguage.indexOf("-") > 0){
            browserLanguage = rawBrowserLanguage.split("-")[0];
        }

        if (browserLanguage!=null){
            this.setLanguage(browserLanguage);
        }else{
            this.setLanguage(defaultLanguage);
        }
    }

    setLanguage(language:string):void{
        console.log("Setting language as "+language);
        this.currentLanguage = language;
        this.sendEvent(LANGUAGE_CHANGED_EVENT);
    }

    getLanguage():string{
        return this.currentLanguage;
    }

    sendEvent(event:String){
        this.subscriber.next({event:event});
    }

    getObservable():Observable<any>{
        return this.subscriber.asObservable();
    }
}
