package com.example.hibernateenvers.domain;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class CustomRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        EnversRevinfo revinfo = (EnversRevinfo) revisionEntity;
        SecurityContext ctx = SecurityContextHolder.getContext();

        Authentication auth = ctx.getAuthentication();
        if (auth != null && auth.isAuthenticated())
            revinfo.setUsername(((User) auth.getPrincipal()).getUsername());
    }
}
