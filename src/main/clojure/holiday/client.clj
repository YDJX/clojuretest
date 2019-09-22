(ns holiday.client)
(import 'java.util.Calendar)

(defn holiday-status
  [game-id type]
    "holiday-status is called."
  {:name "holiday xx" :id game-id :type type :created (.getTime (Calendar/getInstance) )}
  )
(defn holiday-rewards
  [game-id type users datas]
  1)