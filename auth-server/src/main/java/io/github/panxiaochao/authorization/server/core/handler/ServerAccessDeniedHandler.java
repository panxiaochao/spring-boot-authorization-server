package io.github.panxiaochao.authorization.server.core.handler;

import io.github.panxiaochao.core.response.R;
import io.github.panxiaochao.core.utils.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * 权限不足异常类重写.
 * </p>
 *
 * @author LyPxc
 */
public class ServerAccessDeniedHandler implements AccessDeniedHandler {

	private final Logger log = LoggerFactory.getLogger(ServerAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(JacksonUtil.toString(R.fail(HttpStatus.FORBIDDEN.value(), "OAUTH_TOKEN_DENIED", null)));
		out.flush();
		out.close();
	}

}
