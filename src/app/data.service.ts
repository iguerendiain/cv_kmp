import { Component,Injectable } from '@angular/core'
import { Observable } from 'rxjs/Observable';
import { Http, Response } from '@angular/http'
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class DataService{
    cvData = null;
    currentLanguage = null;

    constructor(private http:Http){}

    downloadData():Observable<any>{
        return this.http.get("assets/db.json").map(res => res.json());
    }

    setData(data):void{
        this.cvData = data;
    }

    getData():any{
        return this.cvData;
    }

    autoSetLanguage():void{
        this.setLanguage(this.cvData.defaultLanguage);
    }

    setLanguage(language:string):void{
        this.currentLanguage = language;
    }

    getLanguage():string{
        return this.currentLanguage;
    }
}
