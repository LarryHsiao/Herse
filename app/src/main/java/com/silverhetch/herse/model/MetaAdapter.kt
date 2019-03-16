package com.silverhetch.herse.model

import com.silverhetch.clotho.date.recurring.Meta

/**
 * Adapter for adapting Herase`s one to clotho recurring Meta object.
 */
class MetaAdapter(private val meta: com.silverhetch.herse.model.Meta) : Meta {
    override fun day(): Int {
        return meta.day
    }

    override fun interval(): Long {
        return meta.interval
    }

    override fun month(): Int {
        return meta.month
    }

    override fun start(): Long {
        return meta.start
    }

    override fun week(): Int {
        return meta.week
    }

    override fun weekday(): Int {
        return meta.weekday
    }

    override fun year(): Int {
        return meta.year
    }
}