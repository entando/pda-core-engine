package org.entando.plugins.pda.core.exception;

public class CommentNotFoundException extends NotFoundException {

    public CommentNotFoundException(Throwable e) {
        super("org.entando.error.comment.notFound", e);
    }

    public CommentNotFoundException() {
        this(null);
    }

}
