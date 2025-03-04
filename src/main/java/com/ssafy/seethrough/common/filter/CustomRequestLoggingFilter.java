package com.ssafy.seethrough.common.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

@Slf4j
public class CustomRequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 래퍼로 요청을 감싸서 본문을 읽을 수 있게 함
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

        // 필터 체인 계속 실행
        filterChain.doFilter(wrappedRequest, response);

        // 요청 시작 시 로깅
        logRequest(wrappedRequest);
    }

    private void logRequest(ContentCachingRequestWrapper request) {
        StringBuilder logMessage = new StringBuilder("\n===== Request Details =====\n");

        // 기본 정보
        logMessage.append("URI        : ").append(request.getRequestURI()).append("\n");
        logMessage.append("Method     : ").append(request.getMethod()).append("\n");
        logMessage.append("Client IP  : ").append(request.getRemoteAddr()).append("\n");

        // 쿼리 스트링
        String queryString = request.getQueryString();
        if (queryString != null && !queryString.isEmpty()) {
            logMessage.append("Query Parameters:\n");

            String[] parameters = queryString.split("&");
            for (String param : parameters) {
                try {
                    // 파라미터 디코딩 및 분리
                    String decodedParam = java.net.URLDecoder.decode(param, "UTF-8");
                    String[] keyValue = decodedParam.split("=", 2);
                    String key = keyValue[0];
                    String value = keyValue.length > 1 ? keyValue[1] : "";

                    // 들여쓰기와 함께 출력
                    logMessage.append("    ").append(key).append(" = ").append(value).append("\n");
                } catch (Exception e) {
                    // 디코딩 실패 시 원본 출력
                    logMessage.append("    ").append(param).append(" (decoding failed)\n");
                }
            }
        } else {
            logMessage.append("Query Parameters: none\n");
        }

        if (request.getContentType() != null && (request.getContentType().contains("application/json")
            || request.getContentType().contains("application/xml"))) {
            // 본문 읽기
            String requestBody;
            try {
                requestBody = new String(
                    ((ContentCachingRequestWrapper) request).getContentAsByteArray(), ((ContentCachingRequestWrapper) request).getCharacterEncoding());
                if (!requestBody.isEmpty()) {
                    logMessage.append("---Body---\n").append(requestBody).append("\n");
                }
            } catch (Exception e) {
                log.warn("Error reading request body", e);
            }
        }

        logMessage.append("===========================");
        log.info(logMessage.toString());
    }
}
