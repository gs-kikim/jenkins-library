package org.jenkins.utils

class StringValidatorUtil {

    // 사용자 정의 예외 클래스 정의
    static class InvalidFormatException extends RuntimeException {
        InvalidFormatException(String message) {
            super(message)
        }
    }

    // 정규 표현식에 따라 문자열 형식을 검증하는 함수
    static boolean validateString(String input) {
        def gpfPattern = ~/IE-(?:C|B|R)-\d{5}-[\d{1-3}.]+\d{4}_\(.*\).gpf$/
        def imgPattern = ~/INSIGHTS-CT64-(?:C|B|R)-\d{5}-[\d{1-3}.]+\d{4}\.img$/

        if (gpfPattern.matcher(input).find()) {
            return true
        } else if (imgPattern.matcher(input).find()) {
            return true
        } else {
            throw new InvalidFormatException("입력 문자열이 유효하지 않은 형식입니다: ${input}")
        }
    }
}