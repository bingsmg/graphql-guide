package live.cloverescape.graphqlspring.config;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;

/**
 * @author weibb
 */
@Slf4j
@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof ConstraintViolationException) {
            return toGraphQlError(ex);
        } else if (ex instanceof IllegalStateException) {
            log.info("test");
        }
        return super.resolveToSingleError(ex, env);
    }

    private GraphQLError toGraphQlError(Throwable ex) {
        log.error("Exception while handling request: ${ex.message}", ex);
        return GraphqlErrorBuilder.newError()
                .message(ex.getMessage())
                .errorType(ErrorType.DataFetchingException)
                .build();
    }
}
