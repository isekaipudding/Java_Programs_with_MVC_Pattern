package com.example.calculator.service;

import com.example.calculator.model.DTO;

public class Functions {
    // ── DTO 기반 API: dto.getInputA/B() 파싱 → 연산 → dto.setResult(...) ──
    public void plus(DTO dto) {
        long a = parseLong(dto.getInputA());
        long b = parseLong(dto.getInputB());
        dto.setResult(String.valueOf(a + b));
    }

    public void sub(DTO dto) {
        long a = parseLong(dto.getInputA());
        long b = parseLong(dto.getInputB());
        dto.setResult(String.valueOf(a - b));
    }

    public void mul(DTO dto) {
        long a = parseLong(dto.getInputA());
        long b = parseLong(dto.getInputB());
        dto.setResult(String.valueOf(a * b));
    }

    public void div(DTO dto) {
        long a = parseLong(dto.getInputA());
        long b = parseLong(dto.getInputB());
        if (b == 0L) throw new ArithmeticException("divide by zero");
        dto.setResult(String.valueOf((double) a / (double) b));
    }

    // ── (선택) 숫자형 API 유지하고 싶을 때 ───────────────────────────
    public int plus(int a, int b) { return a + b; }
    public int sub(int a, int b) { return a - b; }
    public long mul(int a, int b) { return (long) a * (long) b; }
    public double div(int a, int b) { return (double) a / (double) b; }

    // ── 내부 유틸 ───────────────────────────────────────────────────
    private static long parseLong(String s) {
        if (s == null) throw new NumberFormatException("null");
        return Long.parseLong(s.trim());
    }
}
