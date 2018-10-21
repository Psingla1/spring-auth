package com.purvi.auth.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role {
  @Id
  @GeneratedValue
  @Column(name = "role_id")
  public int roleId;

  @Column(name = "role")
  public String role;
}
