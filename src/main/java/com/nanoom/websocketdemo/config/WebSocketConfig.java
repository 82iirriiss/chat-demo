package com.nanoom.websocketdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

//  클라이언트가 웹소켓 서버에 연결하는데 사용할 웹소켓 엔드 포인트를 등록
//  Stomp : Simple Text Oriented Messaging Protocol, 데이터 교환의 형식과 규칙을 정의하는 메시징 프로토콜
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        /*
         * withSockJS()
         * 는 웹소켓을 지원하지 않는 브라우저에
         * 폴백 옵션을 활성화하는데 사용됩니다.
         * */
    }

//  클라이언트간에 메시지를 라우팅하는데 사용될 메시지 브로커
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
}
