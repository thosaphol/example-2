import { Component, OnInit } from '@angular/core';
import { Profile, ProfilesService } from 'src/app/services/profiles.service';

@Component({
  selector: 'app-list-profile',
  templateUrl: './list-profile.component.html',
  styleUrls: ['./list-profile.component.css']
})
export class ListProfileComponent implements OnInit{

  profileList: Profile[] = []
  constructor(
    private service:ProfilesService
  ){}

  ngOnInit(): void {
    this.service.getProfiles().subscribe(profiles => {
      this.profileList = profiles;
    })
  }

}
