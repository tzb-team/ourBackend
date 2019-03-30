package com.example.demo.Enum;

public enum  PatentKind {
    作业运输,化学冶金,纺织造纸,物理电学,机械工程照明加热武器爆破,其他;

    @Override
    public String toString(){
        return name();
    }
}
