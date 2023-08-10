package com.stubee.rollingexternal.global.exception.file;

import com.stubee.rollingdomains.common.exception.CustomException;
import com.stubee.rollingdomains.common.exception.ErrorCode;

public class FileConvertException extends CustomException {

    public static final CustomException EXCEPTION = new FileConvertException();

    private FileConvertException() {
        super(ErrorCode.FILE_CONVERT_ERROR);
    }

}