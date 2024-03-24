package com.travel.gogo.security;

import com.travel.gogo.constans.SecurityConstants;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthorizationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(SecurityConstants.HEADER_STRING);

        if (authorizationHeader == null || !authorizationHeader.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            // Không có token được cung cấp, tiếp tục mà không cần xác thực
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.substring(SecurityConstants.TOKEN_PREFIX.length());

        try {
            Authentication authentication = jwtTokenProvider.getAuthentication(token);

            if (authentication != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (JwtException ex) {
            logger.error("Token JWT không hợp lệ", ex);
            // Xử lý các trường hợp ngoại lệ token không hợp lệ (ví dụ: gửi phản hồi không được phép)
        }

        filterChain.doFilter(request, response);
    }
}
