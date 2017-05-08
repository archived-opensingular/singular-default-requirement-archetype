#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${artifactId}.security.security;


import org.opensingular.flow.core.SUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.Collection;

public class DashboardUserDetailsService implements UserDetailsService {

    @Override
    public UIAdminUser loadUserByUsername(String username) {
        return new UIAdminUser(username);
    }

    public static final class UIAdminUser implements UserDetails, SUser {

        private static final String SIMPLENAME = "Admin";
        private static final String EMAIL      = "admin@opensingular.com";
        private final Collection<GrantedAuthority> authoritiesnew;
        private final String                       username;
        private final Integer userCod = 1;


        public UIAdminUser(String username) {
            super();
            this.username = username;
            authoritiesnew = new ArrayList<>(1);
            authoritiesnew.add(new SimpleGrantedAuthority("ROLE_USER"));
        }

        @Override
        public int compareTo(SUser o) {
            int compareTo = getSimpleName().compareTo(o.getSimpleName());
            if (compareTo != 0) {
                return compareTo;
            }
            return getCod().compareTo(o.getCod());
        }

        @Override
        public Integer getCod() {
            return userCod;
        }

        @Override
        public String getSimpleName() {
            return SIMPLENAME;
        }

        @Override
        public String getEmail() {
            return EMAIL;
        }

        @Override
        public String getCodUsuario() {
            return username;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authoritiesnew;
        }

        @Override
        public String getPassword() {
            return "1234";
        }

        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }

}
