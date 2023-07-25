package io.github.panxiaochao.security.core.handler.form;

import io.github.panxiaochao.security.core.constants.GlobalSecurityConstant;
import io.github.panxiaochao.security.core.endpoint.OAuth2EndpointUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 无效Token异常类重新，统一返回Json格式.
 * </p>
 *
 * @author Lypxc
 */
public class ServerFormAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private final Logger log = LoggerFactory.getLogger(ServerFormAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		String msg = OAuth2EndpointUtils.transformAuthenticationException(authException);
		log.error(msg);
		response.sendRedirect(GlobalSecurityConstant.ERROR_PATH);
	}

}
