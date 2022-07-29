package com.example.soccernews.common.utils.adapter

typealias AdapterItemClickListener = () -> Unit
typealias AdapterItemWithParameterClickListener<T> = (T) -> Unit