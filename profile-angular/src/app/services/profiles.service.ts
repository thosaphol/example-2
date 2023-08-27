import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Profile {
  id?: number
  firstName?: string | null
  lastName?: string | null
  phone?: string | null
}

@Injectable({
  providedIn: 'root'
})
export class ProfilesService {

  constructor(
    private http: HttpClient
  ) { }

  getProfiles(): Observable<Profile[]> {
    return this.http.get<Profile[]>('http://localhost:8081/profiles', {})
  }
  addProfile(profile: Profile): Observable<any> {
    return this.http.put('http://localhost:8081/profiles', profile)
  }

  updateProfile(profile:Profile): Observable<any> {
    return this.http.post('http://localhost:8081/profiles', profile)
  }
}
