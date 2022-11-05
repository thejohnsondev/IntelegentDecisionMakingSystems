package com.thejohnsondev.intelegentdecisionmakingsystems.lab1.data

import com.github.adriankuta.datastructure.tree.tree
import com.thejohnsondev.intelegentdecisionmakingsystems.common.util.*

class CarDataSource {

    fun getCarQuestionTree() =
        tree(CAR_TREE_ROOT) {
            child(TYPE_COMFORT) {
                child(FOUR_SEATS) {
                    child(COUNTRY_GERMANY) {
                        child(CAR_MERCEDES_S)
                    }
                    child(COUNTRY_USA) {
                        child(CAR_CADILLAC_ATS)
                    }
                    child(COUNTRY_JAPAN) {
                        child(CAR_TOYOTA_CAMRY)
                    }
                }
                child(TWO_SEATS) {
                    child(COUNTRY_GERMANY) {
                        child(CAR_MERCEDES_E_COUPE)
                    }
                }
                child(SIX_SEATS) {
                    child(COUNTRY_GERMANY) {
                        child(CAR_MERCEDES_GLS)
                    }
                    child(COUNTRY_USA) {
                        child(CAR_TESLA_X)
                    }
                }
            }

            child(TYPE_SPORT) {
                child(FOUR_SEATS) {
                    child(COUNTRY_GERMANY) {
                        child(CAR_MERCEDES_AMG_GT)
                    }
                    child(COUNTRY_USA) {
                        child(CAR_MUSTANG_MACH_E)
                    }
                }
                child(TWO_SEATS) {
                    child(COUNTRY_GERMANY) {
                        child(CAR_LAMBORGHINI)
                    }
                    child(COUNTRY_USA) {
                        child(CAR_DODGE_HELLCAT)
                    }
                    child(COUNTRY_JAPAN) {
                        child(CAR_SUBARU_WRX)
                    }
                }
            }

            child(TYPE_OFF_ROAD) {
                child(FOUR_SEATS) {
                    child(COUNTRY_KOREA) {
                        child(CAR_KIA)
                    }
                    child(COUNTRY_USA) {
                        child(CAR_FORD_F_150)
                    }
                }
                child(SIX_SEATS) {
                    child(COUNTRY_USA) {
                        child(CAR_DODGE_DURANGO)
                    }
                }
            }
        }
}